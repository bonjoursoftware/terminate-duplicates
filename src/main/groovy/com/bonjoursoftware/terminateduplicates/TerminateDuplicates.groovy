/**
 * Terminate Duplicates - Groovy Spock Gradle CLI app that finds and deletes duplicate files
 *
 * https://github.com/bonjoursoftware/terminate-duplicates
 *
 * Copyright (C) 2019 Bonjour Software Limited
 *
 * https://bonjoursoftware.com/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see
 * https://github.com/bonjoursoftware/terminate-duplicates/blob/master/LICENSE
 */
package com.bonjoursoftware.terminateduplicates

import groovy.cli.picocli.CliBuilder
import groovy.util.logging.Slf4j

@Slf4j
class TerminateDuplicates {

    static void main(String[] args) {
        def cli = new CliBuilder(name: 'terminate-duplicates')
        cli.d(longOpt: 'directory', args: 1, argName: 'dir', type: File, defaultValue: '.', 'directory where duplicate files are searched')
        cli.r(longOpt: 'remove', type: Boolean, defaultValue: false, 'remove duplicate files')
        cli.e(longOpt: 'export', type: Boolean, defaultValue: false, 'export duplicate files list to CSV file')
        cli.h(longOpt: 'help', type: Boolean, defaultValue: false, 'print this message')
        cli.usage()
        def options = cli.parse(args)
        log.info "Directory is ${options.directory}"
        log.info "Remove is ${options.remove}"
        log.info "Export is ${options.export}"
        log.info "Arguments are ${options.arguments()}"
    }
}
